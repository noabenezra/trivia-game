import {UserEntity} from "@/models/UserEntity";

const getters = {
    userDetails: (state: { userDetails: UserEntity; }) => state.userDetails,
};

export default getters;