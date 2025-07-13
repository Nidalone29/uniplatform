import { z } from "zod";

interface Course {
  name: string;
  slug: string;
  ects: number;
  type_of_exam: ExamType;
  attendance: Attendance;
}

const examTypeLabels = {
  WRITTEN: "Written Exam",
  ORAL: "Oral Exam",
  PROJECT: "Project",
  PRACTICAL: "Practical Exam",
} as const;

const attendanceLabels = {
  ON_SITE: "On-Site",
  ONLINE_SYNC: "Online (with remote attendance)",
  ONLINE_ASYNC: "Online (with provided video lectures)",
} as const;

type ExamType = keyof typeof examTypeLabels;
type Attendance = keyof typeof attendanceLabels;

// I haven't found a better way of doing this than re-specifying all the enum values
const ExamTypeEnum = z.enum(
  Object.keys(examTypeLabels) as [ExamType, ...ExamType[]],
);

const AttendanceEnum = z.enum(
  Object.keys(attendanceLabels) as [Attendance, ...Attendance[]],
);

const ectsSchema = z.coerce
  .number()
  .int()
  .min(1, {
    message: "Course need to give at least 1 credit.",
  })
  .max(30, {
    message: "Course can't give more than 30 credits.",
  });

const AddCourseFormSchema = z.object({
  name: z.string().min(2, {
    message: "Course name must be at least 2 characters.",
  }),
  ects: ectsSchema,
  type_of_exam: ExamTypeEnum,
  attendance: AttendanceEnum,
});

const EditCourseFormSchema = z.object({
  ects: ectsSchema,
});

export {
  AddCourseFormSchema,
  type Attendance,
  attendanceLabels,
  type Course,
  EditCourseFormSchema,
  type ExamType,
  examTypeLabels,
};
