import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import ky from 'ky';
import { useEffect, useState } from 'react';
import { useNavigate, useParams } from "react-router";

import { UniversityForm } from "../forms/UniversityForm";
import { EditingDialog } from "../common/EditingDialog";
import type { Course } from "@/types/course";

async function getCourses(uni): Promise<Course[]> {
  return await ky("http://localhost:8080/api/universities/" + uni + "/courses/").json<Course[]>();
}

export function CoursesTable() {
  const [courses, setCourses] = useState<Course[]>([]);
  const navigate = useNavigate();

  const params = useParams();

  useEffect(() => {
    getCourses(params.UniID)
      .then(data => setCourses(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table>
          <TableCaption>COURSES Table.</TableCaption>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]">University name</TableHead>
              <TableHead>Courses</TableHead>
              <TableHead>Edit</TableHead>
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
                  <span onClick={e => e.stopPropagation()}>
                    <EditingDialog CustomForm={UniversityForm} />
                  </span>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div >
    </>
  );
}
