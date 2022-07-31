export interface Claims {
    id: number;
    description: string;
    amount: number;
    date: Date;
    status: string;
    user: {
        userId: number;
        firstName: string;
        lastName: string;
    };

}