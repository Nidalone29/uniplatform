import {
  Table,
  TableBody,
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
import { DeleteDialog } from "../common/DeleteDialog";

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
      <div className="flex m-2 align-middle content-center justify-center">
        <Table>
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">Exam name</TableHead>
              <TableHead>ETCS</TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {exams.map(exam => (
              <TableRow>
                <TableCell className="font-medium">{exam.name}</TableCell>
                <TableCell>{exam.ects}</TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog CustomForm={UniversityForm} />
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
