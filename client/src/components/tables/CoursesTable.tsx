import { useLoaderData } from "react-router";

import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import type { loadDataCourse } from "@/api/loadData";
import { AddingDialog } from "@/components/common/AddingDialog";
import { DeleteDialog } from "@/components/common/DeleteDialog";
import { EditingDialog } from "@/components/common/EditingDialog";
import { AddCourseForm } from "@/components/forms/AddCourseForm";
import { ModifyCourseForm } from "@/components/forms/ModifyCourseForm";
import { attendanceLabels, examTypeLabels } from "@/types/course";

export function CoursesTable() {
  const { university, degreeProgram, courses } =
    useLoaderData<typeof loadDataCourse>();

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">
          {degreeProgram!.name} degree program at {university!.name}
        </div>
        <AddingDialog formId="add-course" CustomForm={AddCourseForm} />
      </div>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table>
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">Course name</TableHead>
              <TableHead>ETCS</TableHead>
              <TableHead>Type</TableHead>
              <TableHead>Attendance</TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {courses.map((course) => (
              <TableRow>
                <TableCell className="font-medium">{course.name}</TableCell>
                <TableCell>{course.ects}</TableCell>
                <TableCell>{examTypeLabels[course.type_of_exam]}</TableCell>
                <TableCell>{attendanceLabels[course.attendance]}</TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <EditingDialog
                      formId="edit-course"
                      data={course}
                      CustomForm={ModifyCourseForm}
                    />
                    <DeleteDialog data={course} />
                  </div>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </div>
  );
}
