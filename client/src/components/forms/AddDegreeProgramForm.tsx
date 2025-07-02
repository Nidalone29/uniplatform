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

import { useFormFetcher } from "@/hooks/useFormFetcher";
import {
  AddDegreeProgramFormSchema,
  type DegreeProgram,
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
      </form>
    </Form>
  );
}
