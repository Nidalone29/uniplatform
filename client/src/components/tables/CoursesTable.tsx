import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import ky from 'ky';
import { useEffect, useState } from 'react';
import { useNavigate, useParams } from "react-router";

import type { Course } from "@/types/course";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import { CourseForm } from "../forms/CourseForm";

async function getCourses(uni: string): Promise<Course[]> {
  return await ky("http://localhost:8080/api/universities/" + uni + "/courses/").json<Course[]>();
}

export function CoursesTable() {
  const [courses, setCourses] = useState<Course[]>([]);
  const navigate = useNavigate();

  const params = useParams();

  useEffect(() => {
    getCourses(params.UniID!)
      .then(data => setCourses(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table className="w-full table-fixed">
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">Course name</TableHead>
              <TableHead>Exams</TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {courses.map(course => (
              <TableRow onClick={() => {
                navigate(`${course.slug}`, { viewTransition: true });
              }}>
                <TableCell className="font-medium">{course.name}</TableCell>
                <TableCell>{course.exams.map(exam => (
                  exam.name + ", "
                ))}</TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog data={course} CustomForm={CourseForm} />
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
    </>
  );
}
