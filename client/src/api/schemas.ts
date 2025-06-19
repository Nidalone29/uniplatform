import { z } from "zod";

// TODO the schemas will all be eventually generated via https://github.com/orval-labs/orval
export const ModifyExamFormSchema = z.object({
  ects: z.coerce.number().int()
    .min(1, {
      message: "Exam need to give at least 1 credit.",
    })
    .max(30, {
      message: "Exams can't give more than 30 credits."
    }),
})
