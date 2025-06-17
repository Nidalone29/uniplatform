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

import type { Exam } from "@/types/exam";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import { ModifyExamForm } from "../forms/ModifyExamForm";

async function getAllExams(uni: string, course: string): Promise<Exam[]> {
  return await ky("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/").json<Exam[]>();
}

async function getExam(uni: string, course: string, exam: string): Promise<Exam> {
  return await ky("http://localhost:8080/api/universities/" + uni + "/courses/" + course + "/exams/" + exam).json<Exam>();
}

export function ExamsTable() {
  const [exams, setExams] = useState<Exam[]>([]);
  const params = useParams();
  const university: string = params.UniID!;
  const course: string = params.CourseID!;

  useEffect(() => {
    getAllExams(university, course)
      .then(data => setExams(data))
      .catch(error => console.error("Failed to fetch exams:", error));
  }, []);

  async function updateData(e: Exam) {
    const updatedExam = await getExam(university, course, e.slug);
    setExams(exams.map((exam) => {
      if (exam === e) {
        return updatedExam;
      } else {
        return exam;
      }
    }));
  }

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
                      <EditingDialog data={exam} CustomForm={ModifyExamForm} updateFunct={updateData} />
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
