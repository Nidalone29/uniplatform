import type { ActionFunctionArgs } from "react-router";

import {
  addDataCourse,
  addDataDegreeProgram,
  addDataUniversity,
} from "@/api/addData";
import {
  deleteDataCourse,
  deleteDataDegreeProgram,
  deleteDataUni,
} from "@/api/deleteData";
import { editDataCourse } from "@/api/editData";
import { ContentToURLSearchParams } from "@/lib/utils";
import type { ActionDispatcherRequest } from "@/types/ActionDispatcherRequest";

// basically the goal is to implement the action reducer pattern, by always submitting a post to the route and dealing with an intent/action field
// https://sergiodxa.com/articles/multiple-forms-per-route-in-remix
// similar to https://react.dev/learn/extracting-state-logic-into-a-reducer

export async function manipulateUniversitiesDispatcher({
  request,
}: ActionFunctionArgs) {
  const {
    intent,
    slug: university_slug,
    content,
  }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataUniversity(searchParams);
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

export async function manipulateDegreeProgramDispatcher({
  request,
  params,
}: ActionFunctionArgs) {
  // these are "guaranteed" by react-router
  const university_slug: string = params.UniID!;

  const {
    intent,
    slug: degreeProgram_slug,
    content,
  }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataDegreeProgram(university_slug, searchParams);
    }
    case "edit": {
      // unsupported for now
      return;
    }
    case "delete": {
      return deleteDataDegreeProgram(university_slug, degreeProgram_slug!);
    }
    default: {
      throw new Error("Unknown action");
    }
  }
}

export async function manipulateCoursesDispatcher({
  request,
  params,
}: ActionFunctionArgs) {
  // these are "guaranteed" by react-router
  const university_slug: string = params.UniID!;
  const degreeProgram_slug: string = params.DegreeProgramID!;

  const {
    intent,
    slug: course_slug,
    content,
  }: ActionDispatcherRequest = await request.json();

  switch (intent) {
    case "add": {
      const searchParams = ContentToURLSearchParams(content!);
      return addDataCourse(university_slug, degreeProgram_slug, searchParams);
    }
    case "edit": {
      const searchParams = ContentToURLSearchParams(content!);
      return editDataCourse(
        searchParams,
        university_slug,
        degreeProgram_slug,
        course_slug!,
      );
    }
    case "delete": {
      return deleteDataCourse(
        university_slug,
        degreeProgram_slug,
        course_slug!,
      );
    }
    default: {
      throw new Error("Unknown action");
    }
  }
}
