import { Link, useLoaderData } from "react-router";

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
import { degreeProgramTypeLabels } from "@/types/degreeProgram";

import { Button } from "../ui/button";

export function DegreeProgramsTable() {
  const { university, degreePrograms } =
    useLoaderData<typeof loadDataDegreeProgram>();

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
              <TableHead className="">Degree Program name</TableHead>
              <TableHead className="">Type</TableHead>
              <TableHead className="">Duration</TableHead>
              <TableHead className="w-[180px] text-center">
                Available Courses
              </TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {degreePrograms.map((degreeProgram) => (
              <TableRow>
                <TableCell className="font-medium">
                  {degreeProgram.name}
                </TableCell>
                <TableCell>
                  {degreeProgramTypeLabels[degreeProgram.type]}
                </TableCell>
                <TableCell>
                  {degreeProgram.duration}{" "}
                  {degreeProgram.duration > 1 ? "Years" : "Year"}
                </TableCell>
                <TableCell>
                  <div className="flex justify-center space-x-2">
                    <Button variant={"secondary"} asChild>
                      <Link to={`${degreeProgram.slug}`} viewTransition>
                        View Courses
                      </Link>
                    </Button>
                  </div>
                </TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <EditingDialog
                      formId="edit-course"
                      data={degreeProgram}
                      CustomForm={ModifyDegreeProgramForm}
                    />
                    <DeleteDialog data={degreeProgram} />
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
