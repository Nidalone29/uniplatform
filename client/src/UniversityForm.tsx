import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"
import { toast } from "sonner"
import { z } from "zod"
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import type { ComponentWithDialogControlProps } from "./types/formTypes"

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
const FormSchema = z.object({
  name: z.string().min(2, {
    message: "university name must be at least 2 characters.",
  }),
})

export function UniversityForm({ closingFunct }: ComponentWithDialogControlProps) {
  const form = useForm<z.infer<typeof FormSchema>>({
    resolver: zodResolver(FormSchema),
    defaultValues: {
      name: "",
    },
  })

  // TODO finish form by making the HTTP request and adding toast.success() + close or toast.error() based 
  // on the server response (such as a UniAlreadyExists?)
  function onSubmit(data: z.infer<typeof FormSchema>) {
    closingFunct(false);
    console.log("form submitted!!!")
    toast.success("You submitted the following values", {
      description: (
        <pre className="mt-2 w-full rounded-md p-4">
          <code className="text-white">{JSON.stringify(data, null, 2)}</code>
        </pre>
      ),
      duration: 2000, // 2 seconds
    })
  }

  return (
    <Form {...form}>
      <form id="uniform" onSubmit={form.handleSubmit(onSubmit)} className="w-2/3 space-y-6">
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
  )
}
