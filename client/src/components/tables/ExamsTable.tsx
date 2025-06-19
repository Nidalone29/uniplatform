import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { useLoaderData } from "react-router";
import { useEffect, useState } from 'react';

import type { Exam } from "@/types/exam";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import { ModifyExamForm } from "../forms/ModifyExamForm";
import { getExam } from "@/api/apiCalls";
import type { loadDataExam } from "@/api/loadData";

export function ExamsTable() {
  const { university, course, exams } = useLoaderData<typeof loadDataExam>();
  const [examsState, setExams] = useState<Exam[]>([]);

  useEffect(() => {
    setExams(exams!);
  }, [exams]);

  async function updateData(e?: Exam) {
    const updatedExam: Exam = await getExam(university!.slug, course!.slug, e!.slug);
    setExams(examsState.map((exam) => {
      return (exam === e) ? updatedExam : exam;
    }));
  }

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">{course!.name} course at {university!.name}</div>
      </div>
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
            {examsState.map(exam => (
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
    </div>
  );
}
