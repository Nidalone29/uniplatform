import { useEffect, useState } from "react";
import { useLoaderData, useNavigate } from "react-router";

import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import type { loadDataDegreeProgram } from "@/api/loadData";
import { AddingDialog } from "@/components/common/AddingDialog";
import { DeleteDialog } from "@/components/common/DeleteDialog";
import { EditingDialog } from "@/components/common/EditingDialog";
import { AddDegreeProgramForm } from "@/components/forms/AddDegreeProgramForm";
import { ModifyDegreeProgramForm } from "@/components/forms/ModifyDegreeProgramForm";
import type { DegreeProgram } from "@/types/degreeProgram";

export function DegreeProgramsTable() {
  const { university, degreePrograms } =
    useLoaderData<typeof loadDataDegreeProgram>();
  const [degreeProgramsState, setDegreePrograms] = useState<DegreeProgram[]>(
    [],
  );

  const navigate = useNavigate();

  useEffect(() => {
    setDegreePrograms(degreePrograms!);
  }, [degreePrograms]);

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium">{university!.name}</div>
        <AddingDialog
          formId="add-degree-program"
          CustomForm={AddDegreeProgramForm}
        />
      </div>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table className="w-full table-fixed">
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">Degree Program name</TableHead>
              <TableHead></TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {degreeProgramsState.map((degreeProgram) => (
              <TableRow
                onClick={() => {
                  navigate(`${degreeProgram.slug}`, { viewTransition: true });
                }}
              >
                <TableCell className="font-medium">
                  {degreeProgram.name}
                </TableCell>
                <TableCell></TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={(e) => e.stopPropagation()}>
                      <EditingDialog
                        formId="edit-course"
                        data={degreeProgram}
                        CustomForm={ModifyDegreeProgramForm}
                      />
                    </span>
                    <span onClick={(e) => e.stopPropagation()}>
                      <DeleteDialog data={degreeProgram} />
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
