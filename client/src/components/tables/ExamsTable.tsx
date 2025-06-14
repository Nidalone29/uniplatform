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
import { useParams } from "react-router";
import { useEffect, useState } from 'react';

import { UniversityForm } from "../forms/UniversityForm";
import { EditingDialog } from "../common/EditingDialog";
import type { Exam } from "@/types/exam";

async function getExams(uni, course): Promise<Exam[]> {
  return await ky("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/").json<Exam[]>();
}

export function ExamsTable() {
  const [exams, setExams] = useState<Exam[]>([]);

  const params = useParams();

  useEffect(() => {
    getExams(params.UniID, params.CourseID)
      .then(data => setExams(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
      <div className="flex m-2 align-middle content-center justify-center bg-card">
        <Table>
          <TableCaption>EXAMS Table.</TableCaption>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]">University name</TableHead>
              <TableHead>Courses</TableHead>
              <TableHead>Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {exams.map(exam => (
              <TableRow>
                <TableCell className="font-medium">{exam.name}</TableCell>
                <TableCell>{exam.ects}</TableCell>
                <TableCell>
                  <span onClick={e => e.stopPropagation()}>
                    <EditingDialog CustomForm={UniversityForm} />
                  </span>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </>
  );
}
