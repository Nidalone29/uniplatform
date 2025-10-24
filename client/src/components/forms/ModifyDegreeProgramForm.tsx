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
  type DegreeProgram,
  degreeProgramTypeLabels,
  EditDegreeProgramFormSchema,
} from "@/types/degreeProgram";
import type { FormInDialogProps } from "@/types/formTypes";

export function ModifyDegreeProgramForm({
  formId,
  formData,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<DegreeProgram>) {
  const current_degree_program: DegreeProgram = formData!;
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof EditDegreeProgramFormSchema>>({
    resolver: zodResolver(EditDegreeProgramFormSchema),
    defaultValues: {
      type: current_degree_program.type,
      duration: current_degree_program.duration,
    },
  });

  function onSubmit(data: z.infer<typeof EditDegreeProgramFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction(
      { intent: "edit", slug: current_degree_program.slug, content: data },
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
        <FormField
          control={form.control}
          name="duration"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Duration (in years)</FormLabel>
              <FormControl>
                <Input type="number" placeholder="duration" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
