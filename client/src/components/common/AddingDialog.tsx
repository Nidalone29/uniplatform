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

import { type Entities, type FormInDialogProps } from "@/types/formTypes";

interface EditingDialogProps<T extends Entities> {
  data?: T, // just a passthrough,
  updateFunct?: (updatedData?: T) => void; // just a passthrough,
  CustomForm: React.ComponentType<FormInDialogProps<T>>;
}

export function AddingDialog<T extends Entities>({ CustomForm, updateFunct }: EditingDialogProps<T>) {
  const [openDialog, setOpenDialog] = useState<boolean>(false);

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button className="align-right">Add</Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Creating a new entity</DialogTitle>
        </DialogHeader>
        <CustomForm closingFunct={setOpenDialog} reFetchUpdatedData={updateFunct} />
        <DialogFooter>
          <DialogClose asChild>
            <Button variant="outline">Cancel</Button>
          </DialogClose>
          <Button type="submit" form="add-university-form">Submit</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
