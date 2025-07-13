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
  AddCourseFormSchema,
  attendanceLabels,
  type Course,
  examTypeLabels,
} from "@/types/course";
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
      ects: 8,
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
        <FormField
          control={form.control}
          name="type_of_exam"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Type of exam</FormLabel>
              <Select onValueChange={field.onChange} defaultValue={field.value}>
                <FormControl>
                  <SelectTrigger>
                    <SelectValue placeholder="Select a exam type" />
                  </SelectTrigger>
                </FormControl>
                <SelectContent>
                  {Object.entries(examTypeLabels).map(([k, v]) => (
                    <SelectItem value={k}>{v}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </FormItem>
          )}
        />
        <FormField
          control={form.control}
          name="attendance"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Attendance</FormLabel>
              <Select onValueChange={field.onChange} defaultValue={field.value}>
                <FormControl>
                  <SelectTrigger>
                    <SelectValue placeholder="Select a degree type" />
                  </SelectTrigger>
                </FormControl>
                <SelectContent>
                  {Object.entries(attendanceLabels).map(([k, v]) => (
                    <SelectItem value={k}>{v}</SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
