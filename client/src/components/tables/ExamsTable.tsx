import { useLoaderData } from "react-router";

import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import type { loadDataExam } from "@/api/loadData";
import { AddingDialog } from "@/components/common/AddingDialog";
import { DeleteDialog } from "@/components/common/DeleteDialog";
import { EditingDialog } from "@/components/common/EditingDialog";
import { AddExamForm } from "@/components/forms/AddExamForm";
import { ModifyExamForm } from "@/components/forms/ModifyExamForm";
import type { Exam } from "@/types/exam";

export function ExamsTable() {
  const { university, course, exams } = useLoaderData<typeof loadDataExam>();

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">
          {course!.name} course at {university!.name}
        </div>
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
            {exams.map((exam) => (
              <TableRow>
                <TableCell className="font-medium">{exam.name}</TableCell>
                <TableCell>{exam.ects}</TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={(e) => e.stopPropagation()}>
                      <EditingDialog<Exam>
                        formId="edit-exam"
                        data={exam}
                        CustomForm={ModifyExamForm}
                      />
                    </span>
                    <span onClick={(e) => e.stopPropagation()}>
                      <DeleteDialog data={exam} />
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
