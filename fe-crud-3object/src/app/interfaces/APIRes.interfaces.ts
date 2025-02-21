import { StatusDT } from './Status.interfaces';
export interface APIRes {
  status: boolean;
  message: string;
  content: StatusDT[];
}
