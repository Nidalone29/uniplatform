import {
  getCourses,
  getDegreeProgram,
  getDegreePrograms,
  getUniversities,
  getUniversity,
} from "@/api/apiCalls";

export async function loadDataUniversity() {
  const fetchedUniversities = await getUniversities().catch((error) => {
    console.error("Failed to fetch universities:", error);
    return [];
  });
  return { universities: fetchedUniversities };
}

export async function loadDataDegreeProgram(UniID: string) {
  const fetchedDegreePrograms = await getDegreePrograms(UniID).catch(
    (error) => {
      console.error("Failed to fetch degree programs:", error);
      return [];
    },
  );
  const fetchedUniversity = await getUniversity(UniID).catch((error) => {
    console.error("Failed to fetch university:", error);
    return null;
  });
  return {
    university: fetchedUniversity,
    degreePrograms: fetchedDegreePrograms,
  };
}

export async function loadDataCourse(UniID: string, DegreeProgramID: string) {
  const fetchedCourses = await getCourses(UniID, DegreeProgramID).catch(
    (error) => {
      console.error("Failed to fetch courses:", error);
      return [];
    },
  );
  const fetchedDegreeProgram = await getDegreeProgram(
    UniID,
    DegreeProgramID,
  ).catch((error) => {
    console.error("Failed to fetch degree program:", error);
    return null;
  });
  const fetchedUniversity = await getUniversity(UniID).catch((error) => {
    console.error("Failed to fetch university:", error);
    return null;
  });
  return {
    university: fetchedUniversity,
    degreeProgram: fetchedDegreeProgram,
    courses: fetchedCourses,
  };
}
