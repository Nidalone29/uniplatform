import { createBrowserRouter } from "react-router";
import { UniversitiesTable } from "./components/tables/UniversitiesTable";
import { CoursesTable } from "./components/tables/CoursesTable";
import { ExamsTable } from "./components/tables/ExamsTable";
import { MainPage } from "./pages/MainPage";

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
