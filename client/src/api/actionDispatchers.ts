import { ContentToURLSearchParams } from "@/lib/utils";
import type { ActionDispatcherRequest } from "@/types/ActionDispatcherRequest";
import type { ActionFunctionArgs } from "react-router";
import { editDataExam } from "./editData";
import { addDataCourse, addDataExam, addDataUni } from "./addData";
import { deleteDataCourse, deleteDataExam, deleteDataUni } from "./deleteData";

// basically the goal is to implement the action reducer pattern, by always submitting a post to the route and dealing with an intent/action field
// https://sergiodxa.com/articles/multiple-forms-per-route-in-remix
// similar to https://react.dev/learn/extracting-state-logic-into-a-reducer

export async function manipulateUniversitiesDispatcher({ request }: ActionFunctionArgs) {
  const { intent, slug: university_slug, content }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataUni(searchParams);
    }
    case "edit": {
      // unsupported for now
      return;
    }
    case "delete": {
      return deleteDataUni(university_slug!);
    }
    default: {
      throw new Error("Unknown action");
    }
  }
}

export async function manipulateCoursesDispatcher({ request, params }: ActionFunctionArgs) {
  // these are "guaranteed" by react-router
  const university_slug: string = params.UniID!;

  const { intent, slug: course_slug, content }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataCourse(university_slug, searchParams);
    }
    case "edit": {
      // unsupported for now
      return;
    }
    case "delete": {
      return deleteDataCourse(university_slug, course_slug!);
    }
    default: {
      throw new Error("Unknown action");
    }
  }
}

export async function manipulateExamsDispatcher({ request, params }: ActionFunctionArgs) {
  // these are "guaranteed" by react-router
  const university_slug: string = params.UniID!;
  const course_slug: string = params.CourseID!;

  const { intent, slug: exam_slug, content }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataExam(university_slug, course_slug, searchParams);
    }
    case "edit": {
      const searchParams = ContentToURLSearchParams(content!);
      return editDataExam(searchParams, university_slug, course_slug, exam_slug!);
    }
    case "delete": {
      return deleteDataExam(university_slug, course_slug, exam_slug!);
    }
    default: {
      throw new Error("Unknown action");
    }
  }
}
