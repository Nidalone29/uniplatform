import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"

import { Toaster } from "@/components/ui/sonner"

import ky from 'ky'
import type { University } from './types/university';
import { useEffect, useState } from 'react';
import { UniversityForm } from "./UniversityForm";
import { EditingDialog } from "./EditingDialog";

async function getUniversities(): Promise<University[]> {
  return await ky('http://localhost:8080/api/universities/').json<University[]>();
}

export function App() {
  const [universities, setUniversities] = useState<University[]>([]);

  useEffect(() => {
    getUniversities()
      .then(data => setUniversities(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
      <Toaster position="top-center" richColors />
      <div className="flex m-2 align-middle content-center justify-center">
        <Table>
          <TableCaption>A list of your recent invoices.</TableCaption>
          <TableHeader>
            <TableRow>
              <TableHead className="w-[100px]">University name</TableHead>
              <TableHead>Courses</TableHead>
              <TableHead>Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {universities.map(uni => (
              <TableRow>
                <TableCell className="font-medium">{uni.name}</TableCell>
                <TableCell>{uni.courses.map(course => (
                  course.name + ", "
                ))}</TableCell>
                <TableCell>
                  <EditingDialog CustomForm={UniversityForm} />
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </>
  )
}
