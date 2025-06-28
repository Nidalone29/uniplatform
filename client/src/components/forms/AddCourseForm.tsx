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
import { AddCourseFormSchema, type Course } from "@/types/course";
import type { FormInDialogProps } from "@/types/formTypes";

export function AddCourseForm({
  formId,
  closingFunct,
  formStateFunct,
}: FormInDialogProps<Course>) {
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState);
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof AddCourseFormSchema>>({
    resolver: zodResolver(AddCourseFormSchema),
    defaultValues: {
      name: "",
    },
  });

  function onSubmit(data: z.infer<typeof AddCourseFormSchema>) {
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
              <FormLabel>Course Name</FormLabel>
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
