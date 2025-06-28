import { useState } from "react";
import { Loader2Icon, SquarePen } from "lucide-react";

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

import { type DialogProps, type Entities } from "@/types/formTypes";

export function EditingDialog<T extends Entities>({
  formId,
  data,
  CustomForm,
}: DialogProps<T>) {
  const current_data = data!;
  const [openDialog, setOpenDialog] = useState<boolean>(false);
  const [formState, setFormState] = useState<boolean>(false);

  return (
    <Dialog open={openDialog} onOpenChange={setOpenDialog}>
      <DialogTrigger asChild>
        <Button className="items-center gap-2 md:flex-row" variant="secondary">
          <SquarePen />
        </Button>
      </DialogTrigger>
      <DialogContent showCloseButton={!formState}>
        <DialogHeader>
          <DialogTitle>
            Editing{" "}
            {
              current_data.name /* this works because we know that every entity has the property "name" */
            }
          </DialogTitle>
        </DialogHeader>
        <CustomForm
          formData={current_data}
          formId={formId}
          closingFunct={setOpenDialog}
          formStateFunct={setFormState}
        />
        <DialogFooter>
          <DialogClose asChild>
            <Button variant="outline">Cancel</Button>
          </DialogClose>
          <Button type="submit" form={formId} disabled={formState}>
            Submit{" "}
            {formState ? <Loader2Icon className="animate-spin" /> : <></>}
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
