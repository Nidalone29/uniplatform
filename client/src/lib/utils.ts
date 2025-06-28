import { type ClassValue, clsx } from "clsx";
import { twMerge } from "tailwind-merge";

import type { PossibleContentType } from "@/types/ActionDispatcherRequest";

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs));
}

// This function stringifies all the values from the json so that they can be used in URLSearchParams
export function ContentToURLSearchParams(
  input: PossibleContentType,
): URLSearchParams {
  const searchParams = new URLSearchParams();
  for (const [key, value] of Object.entries(input)) {
    searchParams.set(key, value.toString());
  }
  return searchParams;
}
