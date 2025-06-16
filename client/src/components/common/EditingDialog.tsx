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
import { SquarePen } from "lucide-react";

import { type Entities, type FormInDialogProps } from "@/types/formTypes";

interface EditingDialogProps<T extends Entities> {
  data: T, // just a passthrough
  CustomForm: React.ComponentType<FormInDialogProps<T>>;
}

export function EditingDialog<T extends Entities>({ data, CustomForm }: EditingDialogProps<T>) {
  const [openDialog, setOpenDialog] = useState<boolean>(false);

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button className="items-center gap-2 md:flex-row" variant="secondary"><SquarePen /></Button>
      </DialogTrigger>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>Editing {data.name /* this works because we know that every entity has the property "name" */}</DialogTitle>
        </DialogHeader>
        <CustomForm formData={data} closingFunct={setOpenDialog} />
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
