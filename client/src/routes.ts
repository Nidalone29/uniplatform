import { createBrowserRouter } from "react-router";
import { UniversitiesTable } from "./components/tables/UniversitiesTable";
import { CoursesTable } from "./components/tables/CoursesTable";
import { TableLayout } from "./layouts/TableLayout";
import { ExamsTable } from "./components/tables/ExamsTable";

export const router = createBrowserRouter([
  {
    Component: TableLayout,
    children: [
      {
        path: "/",
        handle: "University",
        children: [
          {
            index: true,
            Component: UniversitiesTable,
          },
          {
            path: ":UniID",
            handle: "Course",
            children: [
              {
                index: true,
                Component: CoursesTable,
              },
              {
                path: ":CourseID",
                Component: ExamsTable,
                handle: "Exam",
              },
            ],
          },
        ],
      },
    ],
  },
]);
