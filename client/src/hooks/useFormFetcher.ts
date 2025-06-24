import { useEffect, useState } from "react";
import { useFetcher } from "react-router";
import { toast } from "sonner";

export function useFormFetcher(closingFunct: (open: boolean) => void) {
  const fetcher = useFetcher();
  const [submissionState, setSubmissionState] = useState(false);

  useEffect(() => {
    setSubmissionState(fetcher.state !== "idle");
  }, [setSubmissionState, fetcher.state]);

  useEffect(() => {
    if (fetcher.state === "idle" && fetcher.data != undefined) {
      if (fetcher.data.ok) {
        fetcher.data = undefined; // cleaning the data so it does not "corrupt" subsequent calls
        return () => {
          closingFunct(false);
          toast.dismiss();
          toast.success("Operation completed successfully!", { duration: 2000 });
        }
      } else {
        // here the loader is still called, so there is a possible optimization if we use something like shouldRevalidate
        // https://remix.run/docs/en/main/route/should-revalidate
        // TODO display a different error toast based on the type of error using the fetcher.data
        toast.dismiss();
        toast.error("Error", { duration: 2000 });
      }
    }

  }, [fetcher, fetcher.state, fetcher.data, closingFunct]);

  return { submissionState, submitFunction: fetcher.submit };
}
