import {
  Dialog,
  DialogClose,
  DialogContent,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog"
import { useState } from "react";
import { Button } from "@/components/ui/button";
import { type ComponentWithDialogControlProps } from "../../types/formTypes";

interface EditingDialogProps {
  CustomForm: React.ComponentType<ComponentWithDialogControlProps>;
}

export function EditingDialog({ CustomForm }: EditingDialogProps) {
  const [openDialog, setOpenDialog] = useState<boolean>(false);

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button variant="outline">Edit</Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Are you absolutely sure?</DialogTitle>
        </DialogHeader>
        <CustomForm closingFunct={setOpenDialog} />
        <DialogFooter>
          <DialogClose asChild>
            <Button variant="outline">Cancel</Button>
          </DialogClose>
          <Button type="submit" form="uniform">Submit</Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
