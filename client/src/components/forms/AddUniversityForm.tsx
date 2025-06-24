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

import { type University, AddUniversityFormSchema } from "@/types/university";
import type { FormInDialogProps } from "@/types/formTypes";
import { useFormFetcher } from "@/hooks/useFormFetcher";
import { useEffect } from "react";

export function AddUniversityForm({ formId, closingFunct, formStateFunct }: FormInDialogProps<University>) {
  const { submissionState, submitFunction } = useFormFetcher(closingFunct);

  useEffect(() => {
    formStateFunct!(submissionState)
  }, [formStateFunct, submissionState]);

  const form = useForm<z.infer<typeof AddUniversityFormSchema>>({
    resolver: zodResolver(AddUniversityFormSchema),
    defaultValues: {
      name: "",
    },
  })

  function onSubmit(data: z.infer<typeof AddUniversityFormSchema>) {
    formStateFunct!(true); // just for making this feel more "snappy"
    submitFunction({ intent: "add", content: data }, { method: "POST", encType: "application/json" });
  }

  return (
    <Form {...form}>
      <form id={formId} onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
        <FormField
          control={form.control}
          name="name"
          render={({ field }) => (
            <FormItem>
              <FormLabel>University Name</FormLabel>
              <FormControl>
                <Input placeholder="University of..." {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
