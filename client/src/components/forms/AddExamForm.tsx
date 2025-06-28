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
import { AddExamFormSchema, type Exam } from "@/types/exam";
import type { FormInDialogProps } from "@/types/formTypes";

export function AddExamForm({
  formId,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<Exam>) {
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof AddExamFormSchema>>({
    resolver: zodResolver(AddExamFormSchema),
    defaultValues: {
      name: "",
      ects: 8,
    },
  });

  function onSubmit(data: z.infer<typeof AddExamFormSchema>) {
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
              <FormLabel>Exam Name</FormLabel>
              <FormControl>
                <Input placeholder="Calculus 1" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="ects"
          render={({ field }) => (
            <FormItem>
              <FormLabel>ECTS</FormLabel>
              <FormControl>
                <Input type="number" placeholder="ects" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
