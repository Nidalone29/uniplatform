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
import type { FormInDialogProps } from "@/types/formTypes";
import { EditUniversityFormSchema, type University } from "@/types/university";

export function ModifyUniversityForm({
  formId,
  formData,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<University>) {
  const current_university: University = formData!;
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof EditUniversityFormSchema>>({
    resolver: zodResolver(EditUniversityFormSchema),
    defaultValues: {
      acronym: current_university.acronym,
      country_code: current_university.country_code,
      number_of_programs: current_university.number_of_programs,
    },
  });

  function onSubmit(data: z.infer<typeof EditUniversityFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction(
      { intent: "edit", slug: current_university.slug, content: data },
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
          name="acronym"
          render={({ field }) => (
            <FormItem>
              <FormLabel>University Acronym</FormLabel>
              <FormControl>
                <Input placeholder="TU..." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="country_code"
          render={({ field }) => (
            <FormItem>
              <FormLabel>University Country</FormLabel>
              <FormControl>
                <Input placeholder="Country in ISO 3166" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
