import { createBrowserRouter } from "react-router";

import {
  manipulateCoursesDispatcher,
  manipulateDegreeProgramDispatcher,
  manipulateUniversitiesDispatcher,
} from "@/api/actionDispatchers";
import {
  loadDataCourse,
  loadDataDegreeProgram,
  loadDataUniversity,
} from "@/api/loadData";
import { TableDataSkeleton } from "@/components/common/TableDataSkeleton";
import { CoursesTable } from "@/components/tables/CoursesTable";
import { DegreeProgramsTable } from "@/components/tables/DegreeProgramsTable";
import { UniversitiesTable } from "@/components/tables/UniversitiesTable";
import { MainPage } from "@/pages/MainPage";

export const router = createBrowserRouter([
  {
    Component: MainPage,
    children: [
      {
        path: "/",
        handle: "University",
        children: [
          {
            index: true,
            Component: UniversitiesTable,
            loader: loadDataUniversity,
            action: manipulateUniversitiesDispatcher,
            HydrateFallback: TableDataSkeleton,
          },
          {
            path: ":UniID",
            handle: "Degree Program",
            children: [
              {
                index: true,
                Component: DegreeProgramsTable,
                loader: ({ params }) => loadDataDegreeProgram(params.UniID!),
                action: manipulateDegreeProgramDispatcher,
                HydrateFallback: TableDataSkeleton,
              },
              {
                path: ":DegreeProgramID",
                Component: CoursesTable,
                handle: "Course",
                loader: ({ params }) =>
                  loadDataCourse(params.UniID!, params.DegreeProgramID!),
                action: manipulateCoursesDispatcher,
                HydrateFallback: TableDataSkeleton,
              },
            ],
          },
        ],
      },
    ],
  },
]);
