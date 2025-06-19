import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { useLoaderData, useNavigate } from "react-router";

import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import { ModifyCourseForm } from "../forms/ModifyCourseForm";
import { Button } from "../ui/button";
import { useEffect, useState } from "react";
import type { Course } from "@/types/course";
import type { loadDataCourse } from "@/api/loadData";

export function CoursesTable() {
  const { university, courses } = useLoaderData<typeof loadDataCourse>();
  const [coursesState, setCourses] = useState<Course[]>([]);

  const navigate = useNavigate();

  useEffect(() => {
    setCourses(courses!);
  }, [courses]);

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">{university!.name}</div>
        <Button className="align-right">Add Course</Button>
      </div>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table className="w-full table-fixed">
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">Course name</TableHead>
              <TableHead></TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {coursesState.map(course => (
              <TableRow onClick={() => {
                navigate(`${course.slug}`, { viewTransition: true });
              }}>
                <TableCell className="font-medium">{course.name}</TableCell>
                <TableCell></TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog data={course} CustomForm={ModifyCourseForm} />
                    </span>
                    <span onClick={e => e.stopPropagation()}>
                      <DeleteDialog />
                    </span>
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
