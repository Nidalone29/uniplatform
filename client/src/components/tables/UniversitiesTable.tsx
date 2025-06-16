import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import ky from 'ky';
import { useEffect, useState } from 'react';
import { useNavigate } from "react-router";

import type { University } from '../../types/university';
import { UniversityForm } from "../forms/UniversityForm";
import { EditingDialog } from "../common/EditingDialog";
import { DeleteDialog } from "../common/DeleteDialog";

async function getUniversities(): Promise<University[]> {
  return await ky('http://localhost:8080/api/universities/').json<University[]>();
}

export function UniversitiesTable() {
  const [universities, setUniversities] = useState<University[]>([]);
  const navigate = useNavigate();

  useEffect(() => {
    getUniversities()
      .then(data => setUniversities(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
      <div className="flex m-2 align-middle content-center justify-center ">
        <Table>
          <TableHeader className="bg-card">
            <TableRow>
              <TableHead className="w-[100px]">University name</TableHead>
              <TableHead>Courses</TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {universities.map(uni => (
              <TableRow onClick={() => {
                navigate(`/${uni.slug}`, { viewTransition: true });
              }}>
                <TableCell className="font-medium">{uni.name}</TableCell>
                <TableCell>{uni.courses.map(course => (
                  course.name + ", "
                ))}</TableCell>
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
      </div >
    </>
  );
}
