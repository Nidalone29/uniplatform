import { createBrowserRouter } from "react-router";
import { UniversitiesTable } from "./components/tables/UniversitiesTable";
import { CoursesTable } from "./components/tables/CoursesTable";
import { ExamsTable } from "./components/tables/ExamsTable";
import { MainPage } from "./pages/MainPage";
import { TableDataSkeleton } from "./components/common/TableDataSkeleton";
import { loadDataUni, loadDataCourse, loadDataExam } from "./api/loadData";

// TODO IMPORTANT right now when we load a component in course or exam and we make
// the navbar, we load using loadDataCourse and loadDataExam. These functions make an API call
// to the backed that fetches another list of courses and exams!!! in the near future this will be refactored
// with an appropriate DTO on the backend to just give back the name and slug
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
            loader: loadDataUni,
            HydrateFallback: TableDataSkeleton,
          },
          {
            path: ":UniID",
            handle: "Course",
            children: [
              {
                index: true,
                Component: CoursesTable,
                loader: async ({ params }) => await loadDataCourse(params.UniID!),
                HydrateFallback: TableDataSkeleton,
              },
              {
                path: ":CourseID",
                Component: ExamsTable,
                handle: "Exam",
                loader: ({ params }) => {
                  return loadDataExam(params.UniID!, params.CourseID!)
                },
              },
            ],
          },
        ],
      },
    ],
  },
]);
