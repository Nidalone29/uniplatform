import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { Form } from "@/components/ui/form";
import { useFormFetcher } from "@/hooks/useFormFetcher";
import { useEffect } from "react";

import { EditUniversityFormSchema, type University } from "@/types/university";
import type { FormInDialogProps } from "@/types/formTypes";

export function ModifyUniversityForm({ formId, formData, closingFunct, formStateFunct }: FormInDialogProps<University>) {
  const current_university: University = formData!;
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState)
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof EditUniversityFormSchema>>({
    resolver: zodResolver(EditUniversityFormSchema),
    defaultValues: {

    },
  })

  function onSubmit(data: z.infer<typeof EditUniversityFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction({ intent: "edit", slug: current_university.slug, content: data }, { method: "POST", encType: "application/json" });
  }

  return (
    <Form {...form}>
      <form id={formId} onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
        <p>Unsupported operation</p>
      </form>
    </Form>
  );
}
