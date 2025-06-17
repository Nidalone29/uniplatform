import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { toast } from "sonner";
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
import { useParams } from "react-router";

import type { Exam } from "@/types/exam";
import type { FormInDialogProps } from "@/types/formTypes";
import { updateExam } from "@/api/apiCalls";

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
const FormSchema = z.object({
  ects: z.coerce.number().int()
    .min(1, {
      message: "Exam need to give at least 1 credit.",
    }).max(30, {
      message: "Exams can't give more than 30 credits."
    }),
})


export function ModifyExamForm({ formData, closingFunct, reFetchUpdatedData }: FormInDialogProps<Exam>) {
  const params = useParams();
  const university: string = params.UniID!;
  const course: string = params.CourseID!;
  const exam: Exam = formData;
  const reFetchExam: (updatedData: Exam) => void = reFetchUpdatedData!;

  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      ects: exam.ects,
    },
  })

  function onSubmit(data: z.infer<typeof FormSchema>) {
    closingFunct(false);
    updateExam(university, course, exam.slug, data.ects)
      .then(() => (
        toast.success("Exam Updated Successfully", { duration: 2000 /*2 seconds*/ }),
        reFetchExam(exam)
      ))
      .catch((error) => (
        console.log(error),
        toast.error("Error", { duration: 2000 })
      ));
  }

  return (
    <Form {...form}>
      <form id="uniform" onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
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
