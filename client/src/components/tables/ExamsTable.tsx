import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { useLoaderData } from "react-router";

import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import { ModifyExamForm } from "../forms/ModifyExamForm";
import type { loadDataExam } from "@/api/loadData";
import { AddingDialog } from "../common/AddingDialog";
import { AddExamForm } from "../forms/AddExamForm";

export function ExamsTable() {
  const { university, course, exams } = useLoaderData<typeof loadDataExam>();

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">{course!.name} course at {university!.name}</div>
        <AddingDialog formId="add-exam" CustomForm={AddExamForm} />
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
            {exams.map(exam => (
              <TableRow>
                <TableCell className="font-medium">{exam.name}</TableCell>
                <TableCell>{exam.ects}</TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog formId="edit-exam" data={exam} CustomForm={ModifyExamForm} />
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
