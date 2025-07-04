import ReactCountryFlag from "react-country-flag";
import { Link, useLoaderData } from "react-router";

import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

import type { loadDataUniversity } from "@/api/loadData";
import { AddingDialog } from "@/components/common/AddingDialog";
import { DeleteDialog } from "@/components/common/DeleteDialog";
import { EditingDialog } from "@/components/common/EditingDialog";
import { AddUniversityForm } from "@/components/forms/AddUniversityForm";
import { ModifyUniversityForm } from "@/components/forms/ModifyUniversityForm";
import { regionNamesInEnglish } from "@/lib/utils";

import { Button } from "../ui/button";

export function UniversitiesTable() {
  const { universities } = useLoaderData<typeof loadDataUniversity>();

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
              <TableHead className="">University name</TableHead>
              <TableHead className="">Acronym</TableHead>
              <TableHead className="">Country</TableHead>
              <TableHead className="w-[180px] text-center">
                Available Programs
              </TableHead>
              <TableHead className="w-[104px] text-center">Edit</TableHead>
            </TableRow>
          </TableHeader>
          <TableBody>
            {universities.map((university) => (
              <TableRow>
                <TableCell className="font-medium">{university.name}</TableCell>
                <TableCell className="font-medium">
                  {university.acronym}
                </TableCell>
                <TableCell className="font-medium">
                  <ReactCountryFlag countryCode={university.country_code} svg />{" "}
                  {regionNamesInEnglish.of(university.country_code)}
                </TableCell>
                <TableCell>
                  <div className="flex justify-center space-x-2">
                    <Button variant={"secondary"} asChild>
                      <Link to={`/${university.slug}`} viewTransition>
                        {university.number_of_programs} Degree{" "}
                        {university.number_of_programs > 1
                          ? "Programs"
                          : "Program"}
                      </Link>
                    </Button>
                  </div>
                </TableCell>
                <TableCell>
                  <div className="flex justify-end space-x-2">
                    <EditingDialog
                      formId="edit-university"
                      data={university}
                      CustomForm={ModifyUniversityForm}
                    />
                    <DeleteDialog data={university} />
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
