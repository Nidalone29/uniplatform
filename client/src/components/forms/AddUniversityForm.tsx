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

import type { University } from "@/types/university";
import type { FormInDialogProps } from "@/types/formTypes";
import { addUniversity } from "@/api/apiCalls";

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
const FormSchema = z.object({
  name: z.string().min(2, {
    message: "University name must be at least 2 characters.",
  }),
})

export function AddUniversityForm({ closingFunct, reFetchUpdatedData }: FormInDialogProps<University>) {
  const reFetchUniversities: () => void = reFetchUpdatedData!;

  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      name: "",
    },
  })

  function onSubmit(data: z.infer<typeof FormSchema>) {
    const uniData = new URLSearchParams(); // application/x-www-form-urlencoded
    uniData.set("name", data.name);
    addUniversity(uniData)
      .then(() => (
        toast.success("Exam Updated Successfully", { duration: 2000 }),
        reFetchUniversities(),
        closingFunct(false)
      ))
      .catch((error) => (
        console.log(error),
        toast.error("Error", { duration: 2000 })
      ));
  }

  return (
    <Form {...form}>
      <form id="add-university-form" onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
        <FormField
          control={form.control}
          name="name"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Uni Name</FormLabel>
              <FormControl>
                <Input placeholder="University of caltanissetta" {...field} />
              </FormControl>
              <FormMessage />
            </FormItem>
          )}
        />
      </form>
    </Form>
  );
}
