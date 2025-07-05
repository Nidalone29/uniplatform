import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { Input } from "@/components/ui/input";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";

import { useFormFetcher } from "@/hooks/useFormFetcher";
import {
  AddDegreeProgramFormSchema,
  type DegreeProgram,
  degreeProgramTypeLabels,
} from "@/types/degreeProgram";
import type { FormInDialogProps } from "@/types/formTypes";

export function AddDegreeProgramForm({
  formId,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<DegreeProgram>) {
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof AddDegreeProgramFormSchema>>({
    resolver: zodResolver(AddDegreeProgramFormSchema),
    defaultValues: {
      name: "",
    },
  });

  function onSubmit(data: z.infer<typeof AddDegreeProgramFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction(
      { intent: "add", content: data },
      { method: "POST", encType: "application/json" },
    );
  }

  return (
    <Form {...form}>
      <form
        id={formId}
        onSubmit={form.handleSubmit(onSubmit)}
        className="w-2/3 space-y-6"
      >
        <FormField
          control={form.control}
          name="name"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Degree Program Name</FormLabel>
              <FormControl>
                <Input placeholder="Computer science" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="type"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Degree Program Type</FormLabel>
              <Select onValueChange={field.onChange} defaultValue={field.value}>
                <FormControl>
                  <SelectTrigger>
                    <SelectValue placeholder="Select a degree type" />
                  </SelectTrigger>
                </FormControl>
                <SelectContent>
                  {Object.entries(degreeProgramTypeLabels).map(([k, v]) => (
                    <SelectItem value={k}>{v}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
