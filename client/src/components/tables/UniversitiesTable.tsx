import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import { useLoaderData, useNavigate } from "react-router";
import { ModifyUniversityForm } from "../forms/ModifyUniversityForm";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";
import type { loadDataUni } from "@/api/loadData";
import { AddingDialog } from "../common/AddingDialog";
import { AddUniversityForm } from "../forms/AddUniversityForm";
import type { University } from "@/types/university";
import { useEffect, useState } from "react";
import { getUniversities } from "@/api/apiCalls";

export function UniversitiesTable() {
  const { universities } = useLoaderData<typeof loadDataUni>();
  const [universitiesState, setUniversities] = useState<University[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    setUniversities(universities!);
  }, [universities]);

  async function updateAllData() {
    const updatedUniversities: University[] = await getUniversities();
    setUniversities(updatedUniversities);
  }

  return (
    <div>
      <div className="flex m-2 align-middle content-center justify-between">
        <div className="align-middle font-medium"></div>
        <AddingDialog CustomForm={AddUniversityForm} updateFunct={updateAllData} />
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
            {universitiesState!.map(uni => (
              <TableRow onClick={() => {
                navigate(`/${uni.slug}`, { viewTransition: true });
              }}>
                <TableCell className="font-medium">{uni.name}</TableCell>
                <TableCell></TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <span onClick={e => e.stopPropagation()}>
                      <EditingDialog data={uni} CustomForm={ModifyUniversityForm} />
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
