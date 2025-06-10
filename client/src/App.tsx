import { Button } from '@/components/ui/button'
import {
  Table,
  TableBody,
  TableCaption,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table"
import ky from 'ky'
import type { University } from './types/university';
import { useEffect, useState } from 'react';

async function getUniversities(): Promise<University[]> {
  return await ky('http://localhost:8080/api/universities/').json<University[]>();
}

function App() {
  const [universities, setUniversities] = useState<University[]>([]);

  useEffect(() => {
    getUniversities()
      .then(data => setUniversities(data))
      .catch(error => console.error("Failed to fetch universities:", error));
  }, []);

  return (
    <>
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
                  <Button>
                    EDIT!
                  </Button>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </div>
    </>
  )
}

export default App
