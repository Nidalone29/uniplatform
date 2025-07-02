import { useEffect } from "react";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";
import { z } from "zod";

import { Form } from "@/components/ui/form";

import { useFormFetcher } from "@/hooks/useFormFetcher";
import {
  type DegreeProgram,
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
    defaultValues: {},
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
        <p>Unsupported operation</p>
      </form>
    </Form>
  );
}
