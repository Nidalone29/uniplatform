import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { useState } from "react";

import { type DialogProps, type Entities } from "@/types/formTypes";
import { Loader2Icon } from "lucide-react";

export function AddingDialog<T extends Entities>({ formId, CustomForm }: DialogProps<T>) {
  const [openDialog, setOpenDialog] = useState<boolean>(false);
  const [formState, setFormState] = useState<boolean>(false);

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button className="align-right">Add</Button>
      </DialogTrigger>
      <DialogContent showCloseButton={!formState}>
        <DialogHeader>
          <DialogTitle>Creating a new entity</DialogTitle>
        </DialogHeader>
        <CustomForm formId={formId} closingFunct={setOpenDialog} formStateFunct={setFormState} />
        <DialogFooter>
          <DialogClose asChild>
            <Button variant="outline" disabled={formState}>Cancel</Button>
          </DialogClose>
          <Button type="submit" form={formId} disabled={formState}>
            Submit {formState ? <Loader2Icon className="animate-spin" /> : <></>}
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
