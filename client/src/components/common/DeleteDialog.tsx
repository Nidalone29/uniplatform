import { useEffect, useState } from "react";
import { Loader2Icon, Trash2 } from "lucide-react";

import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";

import { useFormFetcher } from "@/hooks/useFormFetcher";
import type { DeleteDialogProps, Entities } from "@/types/formTypes";

export function DeleteDialog<T extends Entities>({
  data,
}: DeleteDialogProps<T>) {
  const [openDialog, setOpenDialog] = useState<boolean>(false);
  const [formState, setFormState] = useState<boolean>(false);
  const { submissionState, submitFunction } = useFormFetcher(setOpenDialog);

  useEffect(() => {
    setFormState(submissionState);
  }, [setFormState, submissionState]);

  function onSubmit() {
    setFormState(true); // just for making this feel more "snappy"
    submitFunction(
      { intent: "delete", slug: data.slug },
      { method: "POST", encType: "application/json" },
    );
  }

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button
          className="items-center gap-2 md:flex-row"
          variant="destructive"
        >
          <Trash2 />
        </Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>
            Are you absolutely sure you want to delete {data.name}?
          </DialogTitle>
        </DialogHeader>
        <p>
          This will also delete any degree program or course associated with{" "}
          {data.name}, if there are any.
        </p>
        <DialogFooter>
          <DialogClose asChild>
            <Button variant="outline">Cancel</Button>
          </DialogClose>
          <Button type="submit" onClick={() => onSubmit()} disabled={formState}>
            Delete{" "}
            {formState ? <Loader2Icon className="animate-spin" /> : <></>}
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
