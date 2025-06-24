import { createBrowserRouter } from "react-router";
import { UniversitiesTable } from "./components/tables/UniversitiesTable";
import { CoursesTable } from "./components/tables/CoursesTable";
import { ExamsTable } from "./components/tables/ExamsTable";
import { MainPage } from "./pages/MainPage";
import { TableDataSkeleton } from "./components/common/TableDataSkeleton";
import { loadDataUni, loadDataCourse, loadDataExam } from "./api/loadData";
import { manipulateCoursesDispatcher, manipulateExamsDispatcher, manipulateUniversitiesDispatcher } from "./api/actionDispatchers";

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
            action: manipulateUniversitiesDispatcher,
            HydrateFallback: TableDataSkeleton,
          },
          {
            path: ":UniID",
            handle: "Course",
            children: [
              {
                index: true,
                Component: CoursesTable,
                loader: ({ params }) => loadDataCourse(params.UniID!),
                action: manipulateCoursesDispatcher,
                HydrateFallback: TableDataSkeleton,
              },
              {
                path: ":CourseID",
                Component: ExamsTable,
                handle: "Exam",
                loader: ({ params }) => loadDataExam(params.UniID!, params.CourseID!),
                action: manipulateExamsDispatcher,
                HydrateFallback: TableDataSkeleton,
              },
            ],
          },
        ],
      },
    ],
  },
]);
