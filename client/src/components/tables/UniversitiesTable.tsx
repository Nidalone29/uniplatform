import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";
import { Button } from "../ui/button";

import { useLoaderData, useNavigate } from "react-router";
import { UniversityForm } from "../forms/UniversityForm";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import type { loadDataUni } from "@/api/loadData";

export function UniversitiesTable() {
  const { universities } = useLoaderData<typeof loadDataUni>();
  const navigate = useNavigate();

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium"></div>
        <Button className="align-right">Add University</Button>
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
            {universities!.map(uni => (
              <TableRow onClick={() => {
                navigate(`/${uni.slug}`, { viewTransition: true });
              }}>
                <TableCell className="font-medium">{uni.name}</TableCell>
                <TableCell></TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog data={uni} CustomForm={UniversityForm} />
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
