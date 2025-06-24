import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
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

import { type Exam, EditExamFormSchema } from "@/types/exam";
import type { FormInDialogProps } from "@/types/formTypes";
import { useFormFetcher } from "@/hooks/useFormFetcher";
import { useEffect } from "react";

export function ModifyExamForm({ formData, formId, closingFunct, formStateFunct }: FormInDialogProps<Exam>) {
  const current_exam: Exam = formData!;
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState)
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof EditExamFormSchema>>({
    resolver: zodResolver(EditExamFormSchema),
    defaultValues: {
      ects: current_exam.ects,
    },
  })

  function onSubmit(data: z.infer<typeof EditExamFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction({ intent: "edit", slug: current_exam.slug, content: data }, { method: "POST", encType: "application/json" });
  }

  return (
    <Form {...form}>
      <form id={formId} onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
        <FormField
          control={form.control}
          name="ects"
          render={({ field }) => (
            <FormItem>
              <FormLabel>ECTS</FormLabel>
              <FormControl>
                <Input type="number" placeholder="new ects" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
