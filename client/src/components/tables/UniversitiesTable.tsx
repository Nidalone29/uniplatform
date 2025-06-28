import { useLoaderData, useNavigate } from "react-router";

import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import type { loadDataUni } from "@/api/loadData";
import { AddingDialog } from "@/components/common/AddingDialog";
import { DeleteDialog } from "@/components/common/DeleteDialog";
import { EditingDialog } from "@/components/common/EditingDialog";
import { AddUniversityForm } from "@/components/forms/AddUniversityForm";
import { ModifyUniversityForm } from "@/components/forms/ModifyUniversityForm";

export function UniversitiesTable() {
  const { universities } = useLoaderData<typeof loadDataUni>();
  const navigate = useNavigate();

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium"></div>
        <AddingDialog formId="add-university" CustomForm={AddUniversityForm} />
      </div>
      <div className="flex m-2 align-middle content-center justify-center">
        <Table>
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">University name</TableHead>
              <TableHead></TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {universities.map((uni) => (
              <TableRow
                onClick={() => {
                  navigate(`/${uni.slug}`, { viewTransition: true });
                }}
              >
                <TableCell className="font-medium">{uni.name}</TableCell>
                <TableCell></TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={(e) => e.stopPropagation()}>
                      <EditingDialog
                        formId="edit-university"
                        data={uni}
                        CustomForm={ModifyUniversityForm}
                      />
                    </span>
                    <span onClick={(e) => e.stopPropagation()}>
                      <DeleteDialog data={uni} />
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
