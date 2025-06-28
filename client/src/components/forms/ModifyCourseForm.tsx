import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

import { Form } from "@/components/ui/form";

import { useFormFetcher } from "@/hooks/useFormFetcher";
import { type Course, EditCourseFormSchema } from "@/types/course";
import type { FormInDialogProps } from "@/types/formTypes";

export function ModifyCourseForm({
  formId,
  formData,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<Course>) {
  const current_course: Course = formData!;
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof EditCourseFormSchema>>({
    resolver: zodResolver(EditCourseFormSchema),
    defaultValues: {},
  });

  function onSubmit(data: z.infer<typeof EditCourseFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction(
      { intent: "edit", slug: current_course.slug, content: data },
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
        <p>Unsupported operation</p>
      </form>
    </Form>
  );
}
